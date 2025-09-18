#!/bin/bash
# Simple script to randomly select jackson or gson profile and build the project.
profiles=(jackson gson)
selected=${profiles[$RANDOM % ${#profiles[@]}]}
echo "Using profile: $selected"
mvn -q clean package -P${selected}
echo "Build complete."
