*** Settings ***
Documentation    Valid test cases for Event Registration
Resource         keywords.robot
Suite Setup      Suite Setup
Suite Teardown   Suite Teardown
Test Setup       Test Setup
Test Teardown    Test Teardown

*** Variables ***

*** Test Cases ***
UAT-Lab10-001-TC01: Register Success With Organization Info
    [Documentation]    ลงทะเบียนสำเร็จพร้อมข้อมูลองค์กร
    [Tags]    UAT-Lab10-001    Positive    Success    Critical
    Fill Complete Registration Form
    Submit Registration Form
    Verify Success Page

UAT-Lab10-001-TC02: Register Success Without Organization Info
    [Documentation]    ลงทะเบียนสำเร็จโดยไม่มีข้อมูลองค์กร
    [Tags]    UAT-Lab10-001    Positive    Success    Critical
    Fill Registration Form Without Organization
    Submit Registration Form
    Verify Success Page

UAT-Lab10-003-TC01: Valid Phone Format Dash
    [Documentation]    ทดสอบรูปแบบเบอร์โทรศัพท์ XXX-XXX-XXXX
    [Tags]    UAT-Lab10-003    Positive    PhoneFormat    Critical
    Fill Complete Registration Form    phone=${VALID_PHONE_DASH}
    Submit Registration Form
    Verify Success Page

UAT-Lab10-003-TC02: Valid Phone Format Dot
    [Documentation]    ทดสอบรูปแบบเบอร์โทรศัพท์ XXX.XXX.XXXX
    [Tags]    UAT-Lab10-003    Positive    PhoneFormat    Critical
    Fill Complete Registration Form    phone=${VALID_PHONE_DOT}
    Submit Registration Form
    Verify Success Page

UAT-Lab10-003-TC03: Valid Phone Format Space
    [Documentation]    ทดสอบรูปแบบเบอร์โทรศัพท์ XXX XXX XXXX
    [Tags]    UAT-Lab10-003    Positive    PhoneFormat    Critical
    Fill Complete Registration Form    phone=${VALID_PHONE_SPACE}
    Submit Registration Form
    Verify Success Page

UAT-Lab10-004-TC01: Valid Registration With Minimum Required Fields
    [Documentation]    ลงทะเบียนด้วยข้อมูลขั้นต่ำที่จำเป็น
    [Tags]    UAT-Lab10-004    Positive    MinimumData    Normal
    Fill Partial Form    firstname=${VALID_FIRST_NAME}    lastname=${VALID_LAST_NAME}    
    ...                  email=${VALID_EMAIL}    phone=${VALID_PHONE_DASH}
    Submit Registration Form
    Verify Success Page

UAT-Lab10-004-TC02: Valid Registration With All Fields Filled
    [Documentation]    ลงทะเบียนด้วยข้อมูลครบทุกช่อง
    [Tags]    UAT-Lab10-004    Positive    CompleteData    Normal
    Fill Complete Registration Form
    Submit Registration Form
    Verify Success Page

*** Keywords ***