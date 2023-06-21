# Smart-Water-Management-App
Smart Water Management app is an Android app that shall be able to link water billing with water conservation and water supply system efficiency. The app gives a complete system with various
features. The target audience is both citizens and the government, (made initially for one house).

The app is IoT based, and the usage data is directly recorded via a flow sensor from the user's tank via a flow sensor programmed using Arduino UNO and recieved on firebase database of the app using ESP8266. 
The app consists of 2 modules- admin and user. As soon as you open the app, you get 2 options- signup and login and for each option, there are futher 2 options- admin and user. 
After successful login/ signup, you are directed to your respective home page. 

The usage data of each user can be viewed by the admin using the details and statistics feature on the admin home page, and generate the bill accordingly.
The admin can also control the water supply within a specified range using his mobile phone, as there is a float sensor programmed using Arduino to be controlled using app.
Thus, it ,makes everything convenient for the admin, encoraging him to perform his duties more efficiently,
and nullifies chance for scams. 

The user can conveniently pay bill using the app and get regular  water usage updates using the bill and statistics features available on the user home page.The system can thus be helpful, as people would be
aware of their daily water usage and shall be able to manage their daily water usage accordingly to reduce their bills, charged for exact water he/she is using just via using their mobile phone!! , thus
promoting prudent water usage and preventing overuse.

For the app to function properly, make sure that you are connected to internet. The supply feature of admin works only if you have the IoT devices installed within a WiFi range. 

The project is built using Android Studio 2021.2.1 and Arduino IDE. The Arduino UNO is programmed in embedded C.RazorPay API is integrated in this Java based app for bill payment. Layouts are designed in XML.
 
