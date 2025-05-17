# 🌟 Skinova - Skincare Product Android App

![Skinova Banner](https://your-image-link-here.com/banner.png) <!-- Replace with your app banner or screenshot -->

Skinova is an Android skincare product application designed to showcase and manage skincare items. It offers users an intuitive UI to browse, view, and interact with a range of skincare products. The app utilizes **Firebase Realtime Database** for dynamic data storage and retrieval, and is built using **Kotlin** and **XML layouts**.

---

## 📊 Features

* 🏦 Clean and responsive UI built with XML
* 🏠 Home page with product listings
* 📊 Product detail page with descriptions, images, and pricing
* 🛋️ Add to Cart functionality
* 📑 Realtime data updates from Firebase
* 🖊️ Smooth image loading using Glide
* 📊 Dots indicator for image sliders

---

## 📁 Project Structure

```
Skinova/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/skinova/
│   │   │   │   ├── Adapter/
│   │   │   │   ├── Helper/
│   │   │   │   ├── Model/
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── drawable/
│   │   │   │   ├── values/
│   │   │   │   └── mipmap/
├── data.json (Uploaded to Firebase)
```

---

## 🚀 Tech Stack

* **Language:** Kotlin
* **UI:** XML Layouts
* **Database:** Firebase Realtime Database
* **Image Loading:** Glide
* **JSON Parsing:** Gson
* **Indicators:** DotsIndicator

---

## 📦 Dependencies

```groovy
dependencies {
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    implementation 'com.google.code.gson:gson:2.8.8'
    implementation 'com.tbuonomo:dotsindicator:4.2'
    implementation platform('com.google.firebase:firebase-bom:32.1.1')
    implementation 'com.google.firebase:firebase-database-ktx'
    implementation 'com.google.firebase:firebase-analytics-ktx'
}
```

---

## 📂 Firebase Integration

* JSON product data is stored in Firebase under a node (e.g., `/products`).
* You can upload the JSON using Firebase Console or CLI.
* App fetches this data in real-time and updates the UI.

```json
{
  "products": [
    {
      "title": "Aqualia Thermal Spa Effect",
      "price": 19.99,
      "picUrl": ["https://your-image-link.com/image1.jpg"],
      "description": "Hydrating cream for fresh and plump skin."
    },
    ...
  ]
}
```

---

## 📱 Screenshots

| Home Screen                         | Product Details                       | Cart Page                           |
| ----------------------------------- | ------------------------------------- | ----------------------------------- |
| https://github.com/kumarashish77/Skinova/blob/main/img.jpg?raw=true | https://github.com/kumarashish77/Skinova/blob/main/img3.jpg?raw=true| https://github.com/kumarashish77/Skinova/blob/main/img5.jpg?raw=true |



---

## 🔧 How to Run

1. Clone this repository:

```bash
git clone https://github.com/yourusername/Skinova.git
```

2. Open in Android Studio.
3. Connect Firebase to your project (Tools > Firebase > Realtime Database).
4. Sync Gradle and Run the app on an emulator or device.

---

## 🎓 Author

**Ashish Kumar**


---

## 🌍 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 🚀 Future Enhancements

* Add user authentication (login/register)
* Product search and filters
* Dark mode
* In-app purchases or cart checkout

---

If you like this project, consider giving it a ⭐ on GitHub!
