#!/usr/bin/env bash


mvn versions:set -DnewVersion=$1
mvn compile jib:build
git add docker-compose/docker-compose.yaml
git add pom.xml
