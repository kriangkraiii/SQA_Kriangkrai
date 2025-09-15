*** Settings ***
Documentation    Common keywords for Event Registration Testing
Resource         config.robot

*** Keywords ***
# Browser Management
Open Test Browser
    [Documentation]    เปิด Browser สำหรับการทดสอบ
    Open Browser    ${REGISTRATION_URL}    ${BROWSER}
    Set Selenium Speed    ${DELAY}
    Set Window Size    1280    720

Close Test Browser
    [Documentation]    ปิด Browser
    Close Browser

# Page Navigation
Navigate To Registration Page
    [Documentation]    ไปยังหน้า Event Registration
    Go To    ${REGISTRATION_URL}
    Wait Until Page Contains Element    ${FIRSTNAME_FIELD}    timeout=10s
    Page Should Contain    Event Registration

# Form Management
Clear All Form Fields
    [Documentation]    ล้างข้อมูลทุกช่องในฟอร์ม
    Execute Javascript    
    ...    try {
    ...        document.getElementById('firstname').value = '';
    ...        document.getElementById('lastname').value = '';
    ...        document.getElementById('organization').value = '';
    ...        document.getElementById('email').value = '';
    ...        document.getElementById('phone').value = '';
    ...        document.getElementById('errors').innerHTML = '';
    ...    } catch(e) {
    ...        console.log('Form clearing error: ' + e.message);
    ...    }

Fill Form Field
    [Arguments]    ${field_locator}    ${value}
    [Documentation]    กรอกข้อมูลในช่องที่กำหนด
    Wait Until Element Is Visible    ${field_locator}    timeout=5s
    Clear Element Text    ${field_locator}
    Input Text    ${field_locator}    ${value}

Submit Registration Form
    [Documentation]    กดปุ่มลงทะเบียน
    Click Button    ${REGISTER_BUTTON}
    Sleep    2s    # รอให้ form submit และ redirect

# Verification Keywords - แก้ไขให้รองรับ URL with parameters
Verify Success Page
    [Documentation]    ตรวจสอบหน้า Success
    # รอให้หน้าโหลด และตรวจสอบว่า URL มี Success.html
    Wait Until Location Contains    Success.html    timeout=7s
    Wait Until Page Contains    Success    timeout=5s
    Page Should Contain    Thank you for participating in our event
    Title Should Be    Success
    Log    Success page verified successfully

Verify Error Message
    [Arguments]    ${expected_message}
    [Documentation]    ตรวจสอบข้อความแสดงข้อผิดพลาด
    Wait Until Element Contains    ${ERROR_MESSAGE}    ${expected_message}    timeout=5s
    Element Should Contain    ${ERROR_MESSAGE}    ${expected_message}

Verify Still On Registration Page
    [Documentation]    ตรวจสอบว่ายังอยู่ในหน้า Registration
    Location Should Contain    Registration.html
    Page Should Contain    Event Registration

# Form Fill Keywords
Fill Complete Registration Form
    [Arguments]    ${firstname}=${VALID_FIRST_NAME}    ${lastname}=${VALID_LAST_NAME}    
    ...           ${organization}=${VALID_ORGANIZATION}    ${email}=${VALID_EMAIL}    
    ...           ${phone}=${VALID_PHONE_DASH}
    [Documentation]    กรอกฟอร์มลงทะเบียนแบบครบถ้วน
    Clear All Form Fields
    Fill Form Field    ${FIRSTNAME_FIELD}      ${firstname}
    Fill Form Field    ${LASTNAME_FIELD}       ${lastname}
    Fill Form Field    ${ORGANIZATION_FIELD}   ${organization}
    Fill Form Field    ${EMAIL_FIELD}          ${email}
    Fill Form Field    ${PHONE_FIELD}          ${phone}

Fill Registration Form Without Organization
    [Arguments]    ${firstname}=${VALID_FIRST_NAME}    ${lastname}=${VALID_LAST_NAME}    
    ...           ${email}=${VALID_EMAIL}    ${phone}=${VALID_PHONE_DASH}
    [Documentation]    กรอกฟอร์มลงทะเบียนโดยไม่มีองค์กร
    Clear All Form Fields
    Fill Form Field    ${FIRSTNAME_FIELD}    ${firstname}
    Fill Form Field    ${LASTNAME_FIELD}     ${lastname}
    Fill Form Field    ${EMAIL_FIELD}        ${email}
    Fill Form Field    ${PHONE_FIELD}        ${phone}

Fill Partial Form
    [Arguments]    ${firstname}=${EMPTY}    ${lastname}=${EMPTY}    
    ...           ${organization}=${EMPTY}    ${email}=${EMPTY}    ${phone}=${EMPTY}
    [Documentation]    กรอกฟอร์มบางส่วนตามที่กำหนด
    Clear All Form Fields
    Run Keyword If    '${firstname}' != '${EMPTY}'      Fill Form Field    ${FIRSTNAME_FIELD}      ${firstname}
    Run Keyword If    '${lastname}' != '${EMPTY}'       Fill Form Field    ${LASTNAME_FIELD}       ${lastname}
    Run Keyword If    '${organization}' != '${EMPTY}'   Fill Form Field    ${ORGANIZATION_FIELD}   ${organization}
    Run Keyword If    '${email}' != '${EMPTY}'          Fill Form Field    ${EMAIL_FIELD}          ${email}
    Run Keyword If    '${phone}' != '${EMPTY}'          Fill Form Field    ${PHONE_FIELD}          ${phone}

# Setup and Teardown - แก้ไข teardown
Test Setup
    [Documentation]    Setup สำหรับแต่ละ test case
    Navigate To Registration Page

Test Teardown
    [Documentation]    Teardown สำหรับแต่ละ test case
    Run Keyword If    '${TEST STATUS}' == 'FAIL'    Capture Page Screenshot
    # ไปกลับไปหน้า Registration ก่อนจะล้างข้อมูล
    Run Keyword And Ignore Error    Go To    ${REGISTRATION_URL}
    Sleep    1s
    Run Keyword And Ignore Error    Clear All Form Fields

Suite Setup
    [Documentation]    Setup สำหรับ test suite
    Open Test Browser

Suite Teardown
    [Documentation]    Teardown สำหรับ test suite
    Close Test Browser