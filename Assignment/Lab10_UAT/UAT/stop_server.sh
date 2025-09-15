#!/bin/bash

SERVER_PID_FILE=".server.pid"

echo "🛑 Stopping Event Registration Test Server..."

if [ -f "$SERVER_PID_FILE" ]; then
    SERVER_PID=$(cat $SERVER_PID_FILE)
    
    if ps -p $SERVER_PID > /dev/null 2>&1; then
        echo "   Killing server process (PID: $SERVER_PID)..."
        kill $SERVER_PID
        sleep 2
        
        # ตรวจสอบว่าหยุดแล้วหรือไม่
        if ps -p $SERVER_PID > /dev/null 2>&1; then
            echo "   Force killing server..."
            kill -9 $SERVER_PID
        fi
        
        echo "✅ Server stopped successfully"
    else
        echo "⚠️  Server is not running"
    fi
    
    rm -f $SERVER_PID_FILE
else
    echo "⚠️  No server PID file found"
    
    # ลองหา process ที่รันอยู่
    SERVER_PIDS=$(pgrep -f "simple_server.py")
    if [ ! -z "$SERVER_PIDS" ]; then
        echo "   Found running server processes: $SERVER_PIDS"
        echo "   Killing all server processes..."
        pkill -f "simple_server.py"
        echo "✅ All server processes stopped"
    fi
fi