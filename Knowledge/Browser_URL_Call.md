What happens when you search an url on a browser?

1. Browser checks cache to see if requested object is already in cache, if it is then skip to step 9
2. Browser asks operating system for server's IP address 
3. Operating systems makes a DNS Lookup and replies the IP address to the browser
4. Browser opens a TCP connection to server (HTTPS/HTTP), with HTTPS will require SSL layer
5. Browser sends HTTP request through TCP connection
6. Browser receives HTTP response and closes TCP connection if there are no more requests
7. Browser checks response to check for redirect, conition response (3xx status codes), authorization request (401), client errors (4xx), server error (5xx)
8. Cache response if possible
9. Browser decodes response
10. Browser determines how to interpret response (HTML, Javascript, CSS)
11. Browser renders response and messages for unrecognized types

Source - https://stackoverflow.com/questions/2092527/what-happens-when-you-type-in-a-url-in-browser