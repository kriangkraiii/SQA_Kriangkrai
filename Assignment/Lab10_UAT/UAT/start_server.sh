#!/bin/bash

SERVER_PORT=7272
SERVER_PID_FILE=".server.pid"

echo "🌐 Starting Event Registration Test Server..."

# ตรวจสอบว่า server ทำงานอยู่หรือไม่
if [ -f "$SERVER_PID_FILE" ]; then
    SERVER_PID=$(cat $SERVER_PID_FILE)
    if ps -p $SERVER_PID > /dev/null 2>&1; then
        echo "⚠️  Server is already running (PID: $SERVER_PID)"
        echo "   URL: http://localhost:$SERVER_PORT/Lab10/Registration.html"
        exit 0
    else
        rm -f $SERVER_PID_FILE
    fi
fi

# ตรวจสอบว่าไฟล์ HTML มีอยู่หรือไม่
if [ ! -f "Lab10/Registration.html" ]; then
    echo "❌ Registration.html not found in Lab10/ directory"
    echo "   Please make sure Lab10/Registration.html exists"
    exit 1
fi

if [ ! -f "Lab10/Success.html" ]; then
    echo "❌ Success.html not found in Lab10/ directory"
    echo "   Please make sure Lab10/Success.html exists"
    exit 1
fi

# เริ่ม server
echo "🚀 Starting server on port $SERVER_PORT..."
python3 simple_server.py &
SERVER_PID=$!

# บันทึก PID
echo $SERVER_PID > $SERVER_PID_FILE

# รอให้ server เริ่มทำงาน
sleep 3

# ตรวจสอบว่า server ทำงานหรือไม่
if curl -f http://localhost:$SERVER_PORT/Lab10/Registration.html >/dev/null 2>&1; then
    echo "✅ Server is running successfully!"
    echo "   Registration: http://localhost:$SERVER_PORT/Lab10/Registration.html"
    echo "   Success: http://localhost:$SERVER_PORT/Lab10/Success.html"
    echo "   PID: $SERVER_PID (saved to $SERVER_PID_FILE)"
    echo ""
    echo "💡 To stop the server, run: ./stop_server.sh"
else
    echo "❌ Server failed to start or not responding"
    kill $SERVER_PID 2>/dev/null
    rm -f $SERVER_PID_FILE
    exit 1
fi