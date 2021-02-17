## Simple kotlin rest spring boot

Using httpie to test rest API

Check seat
> http :8080/theater/api/seats/1/2

Book seat
> http POST :8080/theater/api/seats/ money=25.00 position:='{"row":1, "number":1}'
