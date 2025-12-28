#!/usr/bin/env bash

FWDIR="$(
  cd "$(dirname "$0")"/.. || exit
  pwd
)"
DATE=$(date --iso-8601=second)

mkdir -p ${FWDIR}/logs
mkdir -p ${FWDIR}/logs/dependencyTree

${FWDIR}/gradlew clean assemble testClasses "${@}"
