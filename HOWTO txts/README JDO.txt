JDO Instructions to create the table structure
--------------------------------

1-Open MySQL Workbench and execute the script located in the sql directory to create the database.

2-Execute "mvn compile" (build and enhance the classes).

3-Execute "mvn datanucleus:schema-create" to create the table structure in the created DB.

4-To delete the schema execute "mvn datanucleus:schema-delete".


(c) Copyright 2008-2011 DataNucleus

