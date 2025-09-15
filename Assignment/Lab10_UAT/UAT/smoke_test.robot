*** Settings ***
Documentation    Smoke tests for Event Registration
Resource         keywords.robot
Suite Setup      Suite Setup
Suite Teardown   Suite Teardown
Test Setup       Test Setup
Test Teardown    Test Teardown

*** Variables ***

*** Test Cases ***
SMOKE-001: Page Load Test
    [Documentation]    ทดสอบการโหลดหน้าเว็บ
    [Tags]    Smoke    Critical
    Page Should Contain    Event Registration
    Element Should Be Visible    ${FIRSTNAME_FIELD}
    Element Should Be Visible    ${LASTNAME_FIELD}
    Element Should Be Visible    ${REGISTER_BUTTON}

SMOKE-002: Basic Registration Flow
    [Documentation]    ทดสอบ flow การลงทะเบียนพื้นฐาน
    [Tags]    Smoke    Critical
    Fill Registration Form Without Organization
    Submit Registration Form
    Verify Success Page

SMOKE-003: Basic Validation Flow
    [Documentation]    ทดสอบ validation พื้นฐาน
    [Tags]    Smoke    Critical
    Submit Registration Form
    Verify Error Message    ${MSG_ENTER_NAME}
    Verify Still On Registration Page

*** Keywords ***