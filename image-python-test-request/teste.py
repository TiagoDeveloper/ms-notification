import requests

url = "http://ms-assinaturas:8080/notification"

payloads = [
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f01"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f02"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f03"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f04"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f05"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f06"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f07"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f08"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f09"},
    {"notification_type" : "SUBSCRIPTION_PURCHASED", "subscription": "5793cf6b3fd833521db8c420955e6f00"},


    {"notification_type" : "SUBSCRIPTION_CANCELED", "subscription": "5793cf6b3fd833521db8c420955e6f06"},
    {"notification_type" : "SUBSCRIPTION_CANCELED", "subscription": "5793cf6b3fd833521db8c420955e6f03"},
    {"notification_type" : "SUBSCRIPTION_CANCELED", "subscription": "5793cf6b3fd833521db8c420955e6f08"},
    {"notification_type" : "SUBSCRIPTION_CANCELED", "subscription": "5793cf6b3fd833521db8c420955e6f00"},


    {"notification_type" : "SUBSCRIPTION_RESTARTED", "subscription": "5793cf6b3fd833521db8c420955e6f06"},
    {"notification_type" : "SUBSCRIPTION_RESTARTED", "subscription": "5793cf6b3fd833521db8c420955e6f00"}
]

headers = {"Content-Type": "application/json"}

for payload in payloads:
    response = requests.request("POST", url, json=payload, headers=headers) 
    print(response)