`asadmin start-domain -v<br />`

```
asadmin --interactive<br />
asadmin> create-jms-resource --restype javax.jms.Queue jms/javaee7/Queue<br />
asadmin> list-jms-resources<br />
asadmin> deploy c13-1.0.war<br />
asadmin> list-components<br />
```

invoking the servlet: localhost:8080/c13-1.0/jms.html?message=hede<br />
and check the server log