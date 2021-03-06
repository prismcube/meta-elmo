#!/bin/sh
############################################################################
#                      NXP PROPRIETARY AND CONFIDENTIAL                    #
#                        SOFTWARE FILE/MODULE HEADER                       #
#                      Copyright NXP Semiconductors 2009                   #
#                            All Rights Reserved                           #
############################################################################
#
# Filename:        stb_sys_startup.sh
#
# Description:     Simple script to startup a development system
#
# Author:          Nitin Garg
#
############################################################################
# $Id: S50_stb_load_app.sh 150154 2010-03-06 02:54:35Z gargn $
############################################################################

#set -x

PATH=/sbin:/bin:/usr/sbin:/usr/bin

echo nameserver 211.47.128.1 > /etc/resolv.conf
/opt/bin/lircd --device=/dev/lirc0 -n --logfile=/dev/null >/dev/null 2>&1 &

if [ -x /opt/bin/autorun.sh ] ; then
    echo "Calling appfs autorun script ..." 
    cd /opt/bin
    ./autorun.sh
fi
