# 🌸 Skinova - Skincare Product Application

![Banner](https://github.com/user-attachments/assets/1ff56205-254d-4453-a024-5586cd3fe079)

**Skinova** is an Android skincare product application designed to showcase and manage skincare items. It offers users an intuitive UI to browse, view, and interact with a range of skincare products. The app utilizes **Firebase Realtime Database** for dynamic data storage and retrieval, and is built using **Kotlin** and **XML layouts**.

---

## 📲 Features

- 🏦 Clean and responsive UI built with XML
- 🏠 Home screen with product listings
- 📋 Product detail pages with descriptions, pricing, and image sliders
- 🛒 Add to Cart functionality
- 🔄 Real-time data updates via Firebase
- 📷 Smooth image loading using Glide
- 🔘 Dots indicator for image sliders

---

## 🗂️ Project Structure

Skinova/
├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/com/example/skinova/
│ │ │ │ ├── Adapter/
│ │ │ │ ├── Helper/
│ │ │ │ ├── Model/
│ │ │ │ └── MainActivity.kt
│ │ │ ├── res/
│ │ │ │ ├── layout/
│ │ │ │ ├── drawable/
│ │ │ │ ├── values/
│ │ │ │ └── mipmap/
├── data.json (Uploaded to Firebase)

yaml
Copy
Edit

---

## 🚀 Tech Stack

| Purpose         | Tech                  |
|----------------|-----------------------|
| Language        | Kotlin                |
| UI Layout       | XML                   |
| Database        | Firebase Realtime DB  |
| Image Loading   | Glide                 |
| JSON Parsing    | Gson                  |
| UI Indicator    | DotsIndicator         |

---

## 📦 Dependencies

```kotlin
dependencies {
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    implementation 'com.google.code.gson:gson:2.8.8'
    implementation 'com.tbuonomo:dotsindicator:4.2'
    implementation platform('com.google.firebase:firebase-bom:32.1.1')
    implementation 'com.google.firebase:firebase-database-ktx'
    implementation 'com.google.firebase:firebase-analytics-ktx'
}
🔥 Firebase Integration
Skincare product data is stored in Firebase under a /products node.

You can upload the JSON file using the Firebase Console or CLI.

The app fetches this data in real-time and dynamically updates the UI.

json
Copy
Edit
{
  "products": [
    {
      "title": "Aqualia Thermal Spa Effect",
      "price": 19.99,
      "picUrl": ["https://your-image-link.com/image1.jpg"],
      "description": "Hydrating cream for fresh and plump skin."
    }
  ]
}
📸 Screenshots
Home Screen	Product Details	Cart Page
		

💡 Replace your_image_2.jpg and your_image_3.jpg with the actual uploaded image URLs.

⚙️ How to Run
Clone this repository:

bash
Copy
Edit
git clone https://github.com/yourusername/Skinova.git
Open the project in Android Studio.

Connect Firebase to your project:
Tools > Firebase > Realtime Database

Upload your JSON data using Firebase Console or CLI.

Sync Gradle.

Run the app on an emulator or device.

👤 Author
Ashish Kumar
B.Tech CSE-AIML | Android Developer & UI/UX Enthusiast

📜 License
This project is open-source and available under the MIT License.

🚀 Future Enhancements
🔐 Add user login and registration

🔎 Product search and filters

🌙 Dark mode support

💳 In-app purchases / cart checkout

⭐️ If you liked this project, please consider giving it a star!

yaml
Copy
Edit

---

### ✅ Tips

- To add more screenshots, upload them to GitHub and paste their URLs in the `Screenshots` section.
- You can keep all images in a folder like `/screenshots` and reference them locally if committing to the repo.

Let me know if you want help generating badges (for Android, Firebase, etc.) or a logo/banner!






