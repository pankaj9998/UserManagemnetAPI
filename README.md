User management API Endpoint
1. Register User http://localhost:8080/api/users/register
   {
  "username": "pankaj",
  "password": "pankaj",
  "email": "pankaj@gmail.com",
  "pinCode": "411033",
  "street": "Pune station",
  "city": "Pune",
  "state": "Maharashtra"
}
2 User Login
Method: POST
URL: http://localhost:8080/api/users/login
{
  "username": "pankaj",
  "password": "pankaj"
}

3. User Search
   By name:
http://localhost:8080/api/users/search?name=jo&page=0&size=5
By pin code:
http://localhost:8080/api/users/search?pinCode=411033
By registration date range:
http://localhost:8080/api/users/search?from=2024-07-01T00:00:00&to=2025-07-01T23:59:59
4. String Permutations
Method: GET
URL:
http://localhost:8080/api/string/permutations?input=ABC
[
  "ABC",
  "ACB",
  "BAC",
  "BCA",
  "CAB",
  "CBA"
]
