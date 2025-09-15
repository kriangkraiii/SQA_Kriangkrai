#!/bin/bash

echo "💨 Running Smoke Tests..."
echo "========================="

# เริ่ม server
./start_server.sh

# รัน smoke tests
echo ""
echo "🧪 Executing smoke tests..."
robot --outputdir results/smoke \
      --loglevel INFO \
      --report smoke_report.html \
      --log smoke_log.html \
      smoke_test.robot

# แสดงผลลัพธ์
RESULT=$?
echo ""
if [ $RESULT -eq 0 ]; then
    echo "✅ Smoke tests PASSED!"
else
    echo "❌ Smoke tests FAILED!"
fi

echo "📊 Results saved to: results/smoke/"
echo "🔍 Open results/smoke/smoke_report.html to view detailed report"

# หยุด server
echo ""
./stop_server.sh

exit $RESULT