<h1 align="center" style="font-size: 2.5em; color: #2F80ED;">GitHub Profiler</h1>

<p align="center" style="font-size: 1.1em;">
  <em>Explore GitHub profiles like never before, right from your mobile device.</em>
</p>

<p align="center">
  <img src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/banner.png" alt="GitHub Profiler Banner" width="80%">
</p>

---

<div style="background-color: #f0f4f8; padding: 1em; border-radius: 5px;">
  <h2 style="color: #2f80ed;">✨ Key Features</h2>
  <ul>
    <li><strong>Instant Profile Search</strong>: Enter any GitHub username to view detailed user information.</li>
    <li><strong>Comprehensive User Stats</strong>: See the user’s profile picture, bio, repositories, and follower statistics.</li>
    <li><strong>Quick Navigation</strong>: Seamlessly jump to user sections, followers, following, and organizations.</li>
    <li><strong>Direct Links</strong>: One-tap links to GitHub profiles and repositories for easy browsing.</li>
  </ul>
</div>

---

<h2 style="color: #2f80ed; text-align: center;">📸 Screenshots</h2>
<p align="center">
  <img src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/Screenshot_1.png" alt="Home Page Screenshot" width="30%">
  <img src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/Screenshot_2.png" alt="User Profile Screenshot" width="30%">
  <img src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/Screenshot_3.png" alt="User Profile Screenshot" width="30%">
</p>

---

<div style="background-color: #f9fbfd; padding: 1em; border: 1px solid #e6ecf0; border-radius: 5px;">
  <h2 style="color: #333;">🚀 Getting Started</h2>
  <p>To get this app running on your Android device, follow these steps:</p>
  <ol>
    <li>Clone this repository: <code>git clone https://github.com/adhamcl/github-profiler.git</code></li>
    <li>Open the project in Android Studio and sync the project dependencies.</li>
    <li>Run the app on an emulator or connected Android device.</li>
  </ol>
</div>

---

<h2 style="color: #2f80ed;">📚 Technologies Used</h2>

<ul style="list-style-type: none; font-family: Arial, sans-serif; padding: 0;">
  <li><strong>Kotlin & Jetpack Compose</strong>: Provides a modern and intuitive Android UI experience with declarative components.</li>
  <li><strong>Navigation Component</strong>: Simplifies navigation and enables better user experience across the app’s screens.</li>
  <li><strong>Splash Screen API</strong>: For a smooth and stylish launch experience, adapting to both light and dark themes.</li>
  <li><strong>Retrofit & OkHttp3</strong>: Manages API requests and retrieves data seamlessly from GitHub with high efficiency.</li>
  <li><strong>Coil</strong>: Handles image loading and caching, ensuring fast and efficient display of user profile images.</li>
  <li><strong>Dagger Hilt</strong>: Provides dependency injection to improve modularity, ease testing, and reduce boilerplate.</li>
  <li><strong>System UI Controller (Accompanist)</strong>: Manages status bar and navigation bar styling, aligning with light and dark mode.</li>
  <li><strong>Accompanist Library</strong>: Offers additional UI enhancements, including drawable painters and insets for responsive design.</li>
  <li><strong>Clean Architecture</strong>: Separates concerns using layers (e.g., data, domain, presentation) for organized, maintainable code.</li>
  <li><strong>Use Cases</strong>: Implements individual business logic operations, keeping code modular and reusable.</li>
  <li><strong>Light & Dark Mode</strong>: Delivers an optimized viewing experience in both themes, adjusting visuals accordingly.</li>
</ul>


---
<p align="center">
  <table style="width: 80%; border-collapse: collapse;">
    <tr style="background-color: #f0f4f8; color: #333;">
      <th style="padding: 10px; border: 1px solid #ddd;">Element</th>
      <th style="padding: 10px; border: 1px solid #ddd;">Color Hex</th>
      <th style="padding: 10px; border: 1px solid #ddd;">Color Preview</th> <!-- New Color Preview Column -->
      <th style="padding: 10px; border: 1px solid #ddd;">Description</th>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Dark App Background</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#0D1117</code></td>
        <td  align="center"><img  src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/0D1117.png" alt="#0D1117" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Primary background color for dark mode.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Light App Background</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#F6F8FA</code></td>
       <td  align="center"><img  src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/F6F8FA.png" alt="#F6F8FA" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Primary background color for light mode.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Error Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#F33333</code></td>
       <td  align="center"><img g src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/F33333.png" alt="#F33333" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Used to indicate errors or critical alerts.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Text Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#AFAFAF</code></td>
       <td  align="center"><img  src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/AFAFAF.png" alt="#AFAFAF" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">General text color for body content.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Title Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#F0F6FC</code></td>
        <td  align="center"><img g src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/F0F6FC.png" alt="#F0F6FC" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Color for headings and titles.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Yes Hireable Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#3FB950</code></td>
   <td  align="center"><img  src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/3FB950.png" alt="#3FB950" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Indicates that the user is available for hire.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">No Hireable Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#A4393A</code></td>
        <td  align="center"><img  src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/A4393A.png" alt="#A4393A" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Indicates that the user is not available for hire.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Horizontal Divider Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#151B23</code></td>
     <td  align="center"><img  src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/151B23.png" alt="#151B23" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Color used for dividing sections in the UI.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Image Background Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#0D1117</code></td>
        <td  align="center"><img  src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/0D1117.png" alt="#0D1117" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Background color for images or cards.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Repository Item Background Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#141D25</code></td>
        <td  align="center"><img  src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/141D25.png" alt="#141D25" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Background color for repository items.</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid #ddd;">Button Color</td>
      <td style="padding: 10px; border: 1px solid #ddd;"><code>#713FC8</code></td>
      <td  align="center"><img src="https://github.com/AdhamCl/GithubProfile/blob/master/README_IMAGES/713FC8.png" alt="#713FC8" style="width: 30px; height: 30px;"></td>
      <td style="padding: 10px; border: 1px solid #ddd;">Color used for buttons in the application.</td>
    </tr>
  </table>
</p>




---

<p align="center">
  <img src="https://github.com/AdhamCl/GithubProfile/blob/master/logo.png" alt="Project Logo" width="150">
</p>
<p align="center">
  Made with ❤️ by Adham
</p>
<p align="center">
  <a href="https://github.com/AdhamCl/GithubProfile">
    <img src="https://img.shields.io/badge/Project-GitHub-blue.svg" alt="GitHub">
  </a>
  <a href="https://linkedin.com/in/adhamcl">
    <img src="https://img.shields.io/badge/LinkedIn-Profile-blue.svg" alt="LinkedIn">
  </a>
</p>
