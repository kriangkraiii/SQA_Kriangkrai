#!/bin/bash

echo "🎯 Custom Test Runner"
echo "===================="
echo ""
echo "Available options:"
echo "1) Run by tags"
echo "2) Run specific test case"
echo "3) Run specific file"
echo "4) Run with custom options"
echo ""

read -p "Choose option (1-4): " choice

case $choice in
    1)
        echo ""
        echo "Available tags: Critical, Normal, Positive, Negative, Smoke, Validation, PhoneFormat"
        read -p "Enter tag to run: " tag
        
        ./start_server.sh
        robot --outputdir results/custom \
              --include $tag \
              --report custom_${tag}_report.html \
              --log custom_${tag}_log.html \
              *.robot
        ./stop_server.sh
        ;;
    2)
        echo ""
        read -p "Enter test case name (e.g., UAT-Lab10-001-TC01): " testcase
        
        ./start_server.sh
        robot --outputdir results/custom \
              --test "*${testcase}*" \
              --report custom_${testcase}_report.html \
              --log custom_${testcase}_log.html \
              *.robot
        ./stop_server.sh
        ;;
    3)
        echo ""
        echo "Available files: smoke_test.robot, valid.robot, invalid.robot"
        read -p "Enter filename: " filename
        
        ./start_server.sh
        robot --outputdir results/custom \
              --report custom_${filename%.*}_report.html \
              --log custom_${filename%.*}_log.html \
              $filename
        ./stop_server.sh
        ;;
    4)
        echo ""
        read -p "Enter custom robot options: " options
        
        ./start_server.sh
        robot --outputdir results/custom $options *.robot
        ./stop_server.sh
        ;;
    *)
        echo "Invalid option"
        exit 1
        ;;
esac

echo ""
echo "📊 Custom test results saved to: results/custom/"