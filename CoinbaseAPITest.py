from coinbase.wallet.client import Client 
#from coinbase.wallet.client import OAuthClient
#client = OAuthClient(access_token, refresh_token)


API_KEY = 'a013fb180472fdb95af0f37e6a5f6b2f'
API_SECRET = '1Qd63AyNTE0kD0mEyq1ZpN8vhpp6BJou504qPhDuDzp6VywVIxAAjn7kk92KMOFl4INXykDjQANKouU4etDB8A=='
api_uri = 'https://api.sandbox.coinbase.com'

client = Client(API_KEY, API_SECRET)

#user = client.get_current_user()

#print(user)


#accounts = client.get_accounts()
print ( client.get_buy_price(currency_pair = 'BTC-USD'))

#print(client.get_accounts())

#print(client.get_current_user())


import json, hmac, hashlib, time, requests
from requests.auth import AuthBase

# Before implementation, set environmental variables with the names API_KEY and API_SECRET


# Create custom authentication for Coinbase API
class CoinbaseWalletAuth(AuthBase):
    def __init__(self, api_key, secret_key):
        self.api_key = api_key
        self.secret_key = secret_key

    def __call__(self, request):
        timestamp = str(int(time.time()))
        message = timestamp + request.method + request.path_url + (request.body or '')
        signature = hmac.new(self.secret_key, message, hashlib.sha256).hexdigest()

        request.headers.update({
            'CB-ACCESS-SIGN': signature,
            'CB-ACCESS-TIMESTAMP': timestamp,
            'CB-ACCESS-KEY': self.api_key,
        })
        return request

api_url = 'https://api.coinbase.com/v2/'
auth = CoinbaseWalletAuth(API_KEY, API_SECRET)

# Get current user
r = requests.get(api_url + 'user', auth=auth)
print (r.json())
# {u'data': {u'username': None, u'resource': u'user', u'name': u'User'...

