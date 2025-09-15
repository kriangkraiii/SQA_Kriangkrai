*** Settings ***
Documentation    Configuration file for Event Registration Testing
Library          SeleniumLibrary

*** Variables ***
# Server Configuration
${SERVER_URL}           http://localhost:7272
${REGISTRATION_URL}     ${SERVER_URL}/Lab10/Registration.html
${SUCCESS_URL}          ${SERVER_URL}/Lab10/Success.html
${BROWSER}              Firefox
${DELAY}                0.2s

# Test Data - Valid
${VALID_FIRST_NAME}     Somsri
${VALID_LAST_NAME}      Sodsai
${VALID_ORGANIZATION}   CS KKU
${VALID_EMAIL}          somsri@kkumail.com
${VALID_PHONE_DASH}     081-001-1234
${VALID_PHONE_DOT}      081.001.1234
${VALID_PHONE_SPACE}    081 001 1234

# Test Data - Invalid
${INVALID_PHONE}        1234
${EMPTY_STRING}         ${EMPTY}

# Expected Messages
${MSG_ENTER_NAME}           *Please enter your name!!
${MSG_ENTER_FIRST_NAME}     *Please enter your first name!!
${MSG_ENTER_LAST_NAME}      *Please enter your last name!!
${MSG_ENTER_EMAIL}          *Please enter your email!!
${MSG_ENTER_PHONE}          *Please enter your phone number!!
${MSG_INVALID_PHONE}        Please enter a valid phone number!!

# Page Elements
${FIRSTNAME_FIELD}      id:firstname
${LASTNAME_FIELD}       id:lastname
${ORGANIZATION_FIELD}   id:organization
${EMAIL_FIELD}          id:email
${PHONE_FIELD}          id:phone
${REGISTER_BUTTON}      id:registerButton
${ERROR_MESSAGE}        id:errors
*** Keywords ***
Wait Until Location Contains
    [Arguments]    ${expected_text}    ${timeout}=10s
    [Documentation]    รอจนกว่า URL จะมีข้อความที่กำหนด
    Wait Until Keyword Succeeds    ${timeout}    1s    Location Should Contain    ${expected_text}