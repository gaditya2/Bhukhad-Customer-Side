# Bhukkad (LNM Food Ordering App)

An Android application to place orders prior from user’s convenience location which can be then taken away when ready. It is to ease and smoothen the ordering process.<br>
After placing order by client, A notification will be sent to client side from firebase and with message “Start Preparation”.<br>
A service is running in background of the app for providing notification to client whenever order is “Ready” or “Delivered”.<br>

###### <h3>Steps To Place Order</h3>
 1. Simply connect to wifi or cellular network. <br>
 2. Sign Up your details (Name, RFID No, Phone No, Password) <br>
 3. If have credentials, Login with RFID No and Password. <br>
 4. You will be presented with Shop List (After Successful Login). <br>
 5. Proceed to shop then from categories choose food items. <br>
 6. Select item quantity and proceed to checkout for placing order. <br>
 7. Random Unique Id will be generated for Order in My Orders. <br>
 8. Orders will be sent to the server. So that Vendor can extract requests and prepare you a delicious food on time. <br>


###### <h3>Working of Application</h3>
Server side is firebase and it’s real time database will be used for authentication and for saving orders.<br>
App provides user to select offline from menu using SqLite and retain the cart even when relogged in .<br>
Ordered Items will not be removed from add to cart till order is delivered.<br>
