# get-coincheck-api-value
１、coincheckのtickerのAPIからGETした結果をJSONで格納する。  
２、JSONの値を取得  

> かなり冗長になっているので後から整形する。

##ticker  
last 最後の取引の価格  
bid 現在の買い注文の最高価格  
ask 現在の売り注文の最安価格  
high 24時間での最高取引価格  
low 24時間での最安取引価格  
volume 24時間での取引量  
timestamp 現在の時刻  