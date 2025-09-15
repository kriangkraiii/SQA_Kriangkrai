*** Settings ***
Documentation    Invalid test cases for Event Registration
Resource         keywords.robot
Suite Setup      Suite Setup
Suite Teardown   Suite Teardown
Test Setup       Test Setup
Test Teardown    Test Teardown

*** Variables ***

*** Test Cases ***
UAT-Lab10-002-TC01: Empty First Name Validation
    [Documentation]    ตรวจสอบการแจ้งเตือนเมื่อไม่กรอกชื่อ
    [Tags]    UAT-Lab10-002    Negative    Validation    Critical
    Fill Partial Form    lastname=${VALID_LAST_NAME}    organization=${VALID_ORGANIZATION}
    ...                  email=${VALID_EMAIL}    phone=${VALID_PHONE_DASH}
    Submit Registration Form
    Verify Error Message    ${MSG_ENTER_FIRST_NAME}
    Verify Still On Registration Page

UAT-Lab10-002-TC02: Empty Last Name Validation
    [Documentation]    ตรวจสอบการแจ้งเตือนเมื่อไม่กรอกนามสกุล
    [Tags]    UAT-Lab10-002    Negative    Validation    Critical
    Fill Partial Form    firstname=${VALID_FIRST_NAME}    organization=${VALID_ORGANIZATION}
    ...                  email=${VALID_EMAIL}    phone=${VALID_PHONE_DASH}
    Submit Registration Form
    Verify Error Message    ${MSG_ENTER_LAST_NAME}
    Verify Still On Registration Page

UAT-Lab10-002-TC03: Empty First Name And Last Name Validation
    [Documentation]    ตรวจสอบการแจ้งเตือนเมื่อไม่กรอกชื่อและนามสกุล
    [Tags]    UAT-Lab10-002    Negative    Validation    Critical
    Fill Partial Form    organization=${VALID_ORGANIZATION}    email=${VALID_EMAIL}    
    ...                  phone=${VALID_PHONE_DASH}
    Submit Registration Form
    Verify Error Message    ${MSG_ENTER_NAME}
    Verify Still On Registration Page

UAT-Lab10-002-TC04: Empty Email Validation
    [Documentation]    ตรวจสอบการแจ้งเตือนเมื่อไม่กรอกอีเมล
    [Tags]    UAT-Lab10-002    Negative    Validation    Critical
    Fill Partial Form    firstname=${VALID_FIRST_NAME}    lastname=${VALID_LAST_NAME}
    ...                  organization=${VALID_ORGANIZATION}    phone=${VALID_PHONE_DASH}
    Submit Registration Form
    Verify Error Message    ${MSG_ENTER_EMAIL}
    Verify Still On Registration Page

UAT-Lab10-002-TC05: Empty Phone Number Validation
    [Documentation]    ตรวจสอบการแจ้งเตือนเมื่อไม่กรอกเบอร์โทรศัพท์
    [Tags]    UAT-Lab10-002    Negative    Validation    Critical
    Fill Partial Form    firstname=${VALID_FIRST_NAME}    lastname=${VALID_LAST_NAME}
    ...                  organization=${VALID_ORGANIZATION}    email=${VALID_EMAIL}
    Submit Registration Form
    Verify Error Message    ${MSG_ENTER_PHONE}
    Verify Still On Registration Page

UAT-Lab10-002-TC06: Invalid Phone Number Format Validation
    [Documentation]    ตรวจสอบการแจ้งเตือนเมื่อกรอกเบอร์โทรศัพท์ไม่ถูกต้อง
    [Tags]    UAT-Lab10-002    Negative    Validation    Critical
    Fill Complete Registration Form    phone=${INVALID_PHONE}
    Submit Registration Form
    Verify Error Message    ${MSG_INVALID_PHONE}
    Verify Still On Registration Page

UAT-Lab10-005-TC01: Empty All Required Fields
    [Documentation]    ตรวจสอบการแจ้งเตือนเมื่อไม่กรอกข้อมูลทุกช่องที่จำเป็น
    [Tags]    UAT-Lab10-005    Negative    Validation    Normal
    Fill Partial Form    organization=${VALID_ORGANIZATION}
    Submit Registration Form
    Verify Error Message    ${MSG_ENTER_NAME}
    Verify Still On Registration Page

UAT-Lab10-005-TC02: Invalid Phone Format Short Number
    [Documentation]    ทดสอบเบอร์โทรศัพท์สั้นเกินไป
    [Tags]    UAT-Lab10-005    Negative    PhoneValidation    Normal
    Fill Complete Registration Form    phone=123
    Submit Registration Form
    Verify Error Message    ${MSG_INVALID_PHONE}
    Verify Still On Registration Page

UAT-Lab10-005-TC03: Invalid Phone Format With Letters
    [Documentation]    ทดสอบเบอร์โทรศัพท์ที่มีตัวอักษร
    [Tags]    UAT-Lab10-005    Negative    PhoneValidation    Normal
    Fill Complete Registration Form    phone=abc-def-ghij
    Submit Registration Form
    Verify Error Message    ${MSG_INVALID_PHONE}
    Verify Still On Registration Page

UAT-Lab10-005-TC04: Invalid Phone Format Mixed Characters
    [Documentation]    ทดสอบเบอร์โทรศัพท์ที่มีอักขระผสม
    [Tags]    UAT-Lab10-005    Negative    PhoneValidation    Normal
    Fill Complete Registration Form    phone=081@001#1234
    Submit Registration Form
    Verify Error Message    ${MSG_INVALID_PHONE}
    Verify Still On Registration Page

*** Keywords ***