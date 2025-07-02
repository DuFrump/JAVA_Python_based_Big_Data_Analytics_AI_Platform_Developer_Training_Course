import requests
import xml.etree.ElementTree as ET
import pandas as pd

key = "5a6152726f6a696838317073527449"
url = f"http://openapi.seoul.go.kr:8088/{key}/json/SPOP_LOCAL_RESD_JACHI/1/5/"

response = requests.get(url)
data = response.json()

rows = data['SPOP_LOCAL_RESD_JACHI']['row']
df = pd.DataFrame(rows)

print(df[['STDR_DE_ID', 'TMZON_PD_SE', 'ADSTRD_CODE_SE', 'TOT_LVPOP_CO']].head())