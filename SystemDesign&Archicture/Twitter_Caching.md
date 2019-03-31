#System Design: Global Caching and consistency

##Scenario: 
Lets take an example of Twitter. There is a huge cache which gets updated frequently. For example: if person Foo tweets and it has followers all across the globe. Ideally all the caches across all PoP needs to get updated. i.e. they should remain in sync.

How does replication across datacenter (PoP) work for realtime caches ? What tools/technologies are preferred ? What are potential issues here in this system design ?

##Solution: 
I would tackle the problem from a slightly different angle: when a user posts something, that something goes in a distributed storage (not necessarily a cache) that is already redundant across multiple geographies.I would also presume that, in the interest of performance, these nodes are eventually consistent.

Now the caching. I would not design a system that takes care of synchronising all the caches each time someone does something. I would rather implement caching at the service level. Imagine a small service residing in a geographically distributed cluster. Each time a user tries to fetch data, the service checks its local cache — if it is a miss, it reads the tweets from the storage and puts a portion of them in a cache (subject to eviction policies). All subsequent accesses, if any, would be cached at a local level.

### In terms of design precautions:

1. Carefully consider the AZ(Availability Zone) topology in order to ensure sufficient bandwidth and low latency
2. Cache at the local level in order to avoid useless network trips
3. Cache updates don’t happen from the centre to the periphery; cache is created when a cache miss happens
4. I am stating the obvious here, implement the right eviction policies in order to keep only the right objects in cache
5. The only message that should go from the centre to the periphery is a cache flush broadcast (tell all the nodes to get rid of their cache)