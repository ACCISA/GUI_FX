import mysql.connector

db = mysql.connector.connect(

    host="127.0.0.1",
    user="root",
    passwd="aniss2003",
    port=3306

)

mycursor = db.cursor()
mycursor.execute("USE appdb")
mycursor.execute("SELECT * FROM accounts")
result = mycursor.fetchall()
mycursor.execute("SELECT * FROM account_creation_logs")
result2 = mycursor.fetchall()
accountList = []
accountLogList = []
for x in result:
    accountList.append(x[1])
for y in result2:
    accountLogList.append(y[2])

print(accountList)
print(accountLogList)

missingUsers = []
for x in range(len(accountList)):
    if accountList[x] not in accountLogList:
        missingUsers.append(accountList[x])

# for users in missingUsers:
#     sql = f"INSERT INTO account_creation_logs (caller, username, original_password, current_password, time) VALUES ({},{},{},{},{})"

# When developping this UI databases are created. Sometimes they are linhked to previous databases and some rows might be missing.
# This script will check specified databases to update the data.




