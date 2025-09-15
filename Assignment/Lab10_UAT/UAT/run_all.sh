#!/bin/bash

echo "🚀 Running All Test Cases..."
echo "============================"

# เริ่ม server
./start_server.sh

OVERALL_RESULT=0

# รัน smoke tests
echo ""
echo "1️⃣  Running Smoke Tests..."
echo "========================="
robot --outputdir results/smoke \
      --loglevel INFO \
      --report smoke_report.html \
      --log smoke_log.html \
      smoke_test.robot

SMOKE_RESULT=$?
if [ $SMOKE_RESULT -ne 0 ]; then
    echo "❌ Smoke tests failed! Stopping execution."
    ./stop_server.sh
    exit 1
fi
echo "✅ Smoke tests passed!"

# รัน valid tests
echo ""
echo "2️⃣  Running Valid Test Cases..."
echo "=============================="
robot --outputdir results/valid \
      --loglevel INFO \
      --report valid_report.html \
      --log valid_log.html \
      valid.robot

VALID_RESULT=$?
if [ $VALID_RESULT -ne 0 ]; then
    OVERALL_RESULT=1
    echo "❌ Some valid tests failed!"
else
    echo "✅ Valid tests passed!"
fi

# รัน invalid tests
echo ""
echo "3️⃣  Running Invalid Test Cases..."
echo "================================"
robot --outputdir results/invalid \
      --loglevel INFO \
      --report invalid_report.html \
      --log invalid_log.html \
      invalid.robot

INVALID_RESULT=$?
if [ $INVALID_RESULT -ne 0 ]; then
    OVERALL_RESULT=1
    echo "❌ Some invalid tests failed!"
else
    echo "✅ Invalid tests passed!"
fi

# รัน combined report
echo ""
echo "4️⃣  Generating Combined Report..."
echo "================================"
robot --outputdir results/combined \
      --loglevel INFO \
      --report combined_report.html \
      --log combined_log.html \
      smoke_test.robot valid.robot invalid.robot

# สรุปผลลัพธ์
echo ""
echo "📊 TEST SUMMARY"
echo "==============="
echo "Smoke Tests:  $([ $SMOKE_RESULT -eq 0 ] && echo "✅ PASSED" || echo "❌ FAILED")"
echo "Valid Tests:  $([ $VALID_RESULT -eq 0 ] && echo "✅ PASSED" || echo "❌ FAILED")"
echo "Invalid Tests: $([ $INVALID_RESULT -eq 0 ] && echo "✅ PASSED" || echo "❌ FAILED")"
echo ""
echo "📁 Results Location:"
echo "   Smoke:    results/smoke/smoke_report.html"
echo "   Valid:    results/valid/valid_report.html"
echo "   Invalid:  results/invalid/invalid_report.html"
echo "   Combined: results/combined/combined_report.html"

# หยุด server
echo ""
./stop_server.sh

if [ $OVERALL_RESULT -eq 0 ]; then
    echo ""
    echo "🎉 ALL TESTS COMPLETED SUCCESSFULLY!"
else
    echo ""
    echo "⚠️  SOME TESTS FAILED - CHECK REPORTS FOR DETAILS"
fi

exit $OVERALL_RESULT