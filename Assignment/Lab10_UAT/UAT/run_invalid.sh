#!/bin/bash

echo "❌ Running Invalid Test Cases..."
echo "================================"

# เริ่ม server
./start_server.sh

# รัน invalid tests
echo ""
echo "🧪 Executing invalid test cases..."
robot --outputdir results/invalid \
      --loglevel INFO \
      --report invalid_report.html \
      --log invalid_log.html \
      --include Negative \
      invalid.robot

# แสดงผลลัพธ์
RESULT=$?
echo ""
if [ $RESULT -eq 0 ]; then
    echo "✅ Invalid tests PASSED!"
else
    echo "❌ Some invalid tests FAILED!"
fi

echo "📊 Results saved to: results/invalid/"
echo "🔍 Open results/invalid/invalid_report.html to view detailed report"

# หยุด server
echo ""
./stop_server.sh

exit $RESULT