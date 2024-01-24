#! /bin/bash

set -x

FILE=/app/.deploy/first_deploy.txt

if [[ -f "$FILE" ]]; then
    echo "No imports to do. Skipping."
else
# Rewriter to only use the single SQL file instead
    WRITERS_FILE=/app/writers.csv
    ARTICLES_FILE=/app/articles.csv
    if [[ -f "$WRITERS_FILE" && -f "$ARTICLES_FILE" ]]
        db_host=`echo $PLATFORM_RELATIONSHIPS | base64 -d | jq -r ".database[0].host"`
        db_port=`echo $PLATFORM_RELATIONSHIPS | base64 -d | jq -r ".database[0].port"`
        db_path=`echo $PLATFORM_RELATIONSHIPS | base64 -d | jq -r ".database[0].path"`
        db_user=`echo $PLATFORM_RELATIONSHIPS | base64 -d | jq -r ".database[0].username"`
        db_pass=`echo $PLATFORM_RELATIONSHIPS | base64 -d | jq -r ".database[0].password"`

#Remove this all section
        writer_table="Writers"
        articles_table="Articles"
        mysql -h $db_host -P $db_port -u $db_user -p $db_pass <<< EOF
         CREATE TABLE IF NOT EXISTS \`$writer_table` (
            id int(11) NOT NULL auto_increment,
            name text,
            datecreate date,
            description text,
            PRIMARY KEY (id)
         ) ENGINE=InnoDB
         EOF
    else
        echo "At least one import file is missing"
    fi
fi


