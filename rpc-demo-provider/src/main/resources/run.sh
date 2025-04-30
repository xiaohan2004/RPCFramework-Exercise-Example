#!/bin/bash

nohup java -jar rpc-demo-provider-1.0-SNAPSHOT.jar &
tail -f nohup.out