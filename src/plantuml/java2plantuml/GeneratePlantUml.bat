@echo off

java -jar java2plantuml.jar src\main\java\ce204_hw2_organization_lib
rename output.puml organization.bak

java -jar java2plantuml.jar src\main\java\ce204_hw2_treatment_lib
rename output.puml treatment.bak

java -jar java2plantuml.jar src\main\java\ce204_hw2_wards_and_teams_lib
rename output.puml wards_and_teams.bak

pause