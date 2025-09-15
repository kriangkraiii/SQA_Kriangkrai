#!/bin/bash

echo "✅ Running Valid Test Cases..."
echo "=============================="

# เริ่ม server
./start_server.sh

# รัน valid tests
echo ""
echo "🧪 Executing valid test cases..."
robot --outputdir results/valid \
      --loglevel INFO \
      --report valid_report.html \
      --log valid_log.html \
      --include Positive \
      valid.robot

# แสดงผลลัพธ์
RESULT=$?
echo ""
if [ $RESULT -eq 0 ]; then
    echo "✅ Valid tests PASSED!"
else
    echo "❌ Some valid tests FAILED!"
fi

echo "📊 Results saved to: results/valid/"
echo "🔍 Open results/valid/valid_report.html to view detailed report"

# หยุด server
echo ""
./stop_server.sh

exit $RESULT