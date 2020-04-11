#!/bin/bash
echo "========The script excute begin========"
baseFolder="/apps/tomcat8080/apache-tomcat-8.0.45/webapps/abnormalImg/"
year=$(date +%Y)
month=`date +%m`
monthStr=${month:0:1}
if [ $monthStr -eq "0"  ];then
 month1=${month#*0}
else
 month1=$month
fi
month2=`expr $month1 - 2`
cd $baseFolder
for dir in $(ls $baseFolder)
do
 if [ -d $dir ];then
  if [ $dir != $year ];then
   echo "The folder "$dir" will be removed"
   rm -rf $dir
  else folder=$baseFolder$year"/"
  fi
 fi
done
cd $folder
for dir1 in $(ls $folder)
do
 if [ -d $dir1 ];then
  if [ $dir1 -lt $month2 ];then
   echo "The folder "$dir1" will be removed"
   rm -rf $dir1
  fi
 fi
done
echo "========The script excute end========"
