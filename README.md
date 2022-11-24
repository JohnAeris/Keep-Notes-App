<h1> Keep Notes v1.0 </h1> 

<h3>ABOUT</h3>
<p>Keep Notes is a note application where the user can add, delete, update, and save a note. The application uses 
a local database called Room Database, therefore, the data from the user will be saved even if the app is closed. 
Since it has a local database, it can be accessed even if the user is offline or it does not need to use the internet.
It is also created with cleaned and structured code using the Model-View-ViewModel Architecture pattern so that it is 
organize, easy to maintain, and update the application.</p>

<h3>FEATURES</h3>
<p>The application has the following features: </p>
<ol type="1">
  <li>Users are allowed to add and save a note.</li>
  <li>Users are allowed to remove a note.</li>
  <li>Users are allowed to update a note.</li>
  <li>It is applicable in light and dark theme.</li>
</ol>

<h3>SREENSHOTS</h3>
<div align="center">
  <img src="https://user-images.githubusercontent.com/89960171/203821898-b24e8731-cd3d-46be-8517-0830508d9061.jpg" width=218 height=473> &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://user-images.githubusercontent.com/89960171/203822033-70e344c4-6c96-4e3c-bf7d-c5233098ee21.jpg" width=218 height=473> &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://user-images.githubusercontent.com/89960171/203822115-88f3042f-b716-40bc-ae5f-531e0574032d.jpg" width=218 height=473> &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://user-images.githubusercontent.com/89960171/203822203-9c951205-8b56-4c06-bfce-e2d172072a51.jpg" width=218 height=473> &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://user-images.githubusercontent.com/89960171/203822247-ef9eadf0-5533-4297-8557-b0a0aaf880c8.jpg" width=218 height=473> &nbsp;&nbsp;&nbsp;&nbsp; 
  <img src="https://user-images.githubusercontent.com/89960171/203822301-fb7697b7-82ad-499d-88de-5ee5f0c118f7.jpg" width=218 height=473> &nbsp;&nbsp;&nbsp;&nbsp; 
  <img src="https://user-images.githubusercontent.com/89960171/203822335-538308c7-2874-483a-b9bb-27f7b62e25b5.jpg" width=218 height=473> &nbsp;&nbsp;&nbsp;&nbsp; 
</div>

<h3>DEMO</h3>
<h4>Light Theme</h4>
<div align="center">
  <video src="https://user-images.githubusercontent.com/89960171/203822480-035262fe-7a1a-499c-8c8d-6022e812c814.mp4" width=218 height=473>
</div>
<h4>Dark Theme</h4>
<div align="center">
  <video src="https://user-images.githubusercontent.com/89960171/203822703-22d9b07a-45f0-44b2-9c95-19960c345583.mp4" width=218 height=473>
</div>




<h3>LIBRARIES</h3>
<p>&nbsp&nbsp&nbsp&nbsp<b>Navigation</b><br>
&nbsp&nbsp&nbsp&nbsp<i>implementation("androidx.navigation:navigation-compose:2.5.3")</i></p>
<p>&nbsp&nbsp&nbsp&nbsp<b>View Model</b><br>
&nbsp&nbsp&nbsp&nbsp<i>implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"</i></p>
<p>&nbsp&nbsp&nbsp&nbsp<b>Hilt-Dagger</b><br>
&nbsp&nbsp&nbsp&nbsp<i>implementation 'com.google.dagger:hilt-android:2.44'<br>
&nbsp&nbsp&nbsp&nbspkapt 'com.google.dagger:hilt-android-compiler:2.44'</i></p>
<p>&nbsp&nbsp&nbsp&nbsp<b>Room Database</b><br>
&nbsp&nbsp&nbsp&nbsp<i>implementation("androidx.room:room-runtime:2.4.3")<br>
&nbsp&nbsp&nbsp&nbspannotationProcessor("androidx.room:room-compiler:2.4.3")</i></p>
<p>&nbsp&nbsp&nbsp&nbsp<b>Coroutines</b><br>
&nbsp&nbsp&nbsp&nbsp<i>implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2'<br>
&nbsp&nbsp&nbsp&nbspimplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2'<br>
&nbsp&nbsp&nbsp&nbspimplementation "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.5.2"</i></p>

<h3>SETUP</h3>
<p>The following are the steps to run the application:</p>
<h4>&emsp;Using Android Studio</h4>
<ol type="1">
  <li>Clone the repository.</li>
  <li>Open the repository using Android Studio.</li>
  <li>Create an virtual emulator in Android Studio using your preferred settings or use physical device.</li>
  <li>Run the mobile application.</li>
</ol>
<h4>&emsp;Using APK</h4>
<ol type="1">
  <li>Click this <a href="https://drive.google.com/file/d/1fi21KiUepM_46MfGDfAJiOmvJRwuiGnE/view?usp=share_link">link</a>.</li>
  <li>Download the Keep Notes apk file.</li>
  <li>Turn on <b>Unknown source installation.</b></li>
  <li>Install the application.</li>
  <li>Click open.</li>
  <li>Run the mobile application.</li>
</ol>
