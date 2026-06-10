# HTML Day 3: Media - Images, Audio & Video

## 📖 Overview

Today you'll learn to embed **multimedia content**—images, audio, and video—into your web pages. Media makes websites more engaging and interactive.

---

## 🎯 Learning Objectives

✅ Embed images with proper attributes  
✅ Use responsive image techniques  
✅ Embed audio content  
✅ Embed video content  
✅ Embed external content with iframes  
✅ Understand media accessibility

---

## 📚 Key Concepts

### **1. Images**

#### **Basic Image**

```html
<img src="image.jpg" alt="Description" />
```

#### **Image with Attributes**

```html
<img src="logo.png" alt="Company Logo" width="200" height="150" class="logo" />
```

#### **Responsive Images**

```html
<img src="image.jpg" alt="Description" style="width: 100%; height: auto;" />
```

---

### **2. Audio**

#### **Basic Audio**

```html
<audio controls>
  <source src="audio.mp3" type="audio/mpeg" />
  Your browser doesn't support audio.
</audio>
```

#### **Attributes**

```html
<audio controls autoplay muted loop>
  <source src="audio.mp3" type="audio/mpeg" />
</audio>
```

---

### **3. Video**

#### **Basic Video**

```html
<video width="400" controls>
  <source src="video.mp4" type="video/mp4" />
  Your browser doesn't support video.
</video>
```

#### **With Multiple Formats**

```html
<video controls width="400" height="300">
  <source src="video.mp4" type="video/mp4" />
  <source src="video.ogg" type="video/ogg" />
  Your browser doesn't support video.
</video>
```

---

### **4. iframes**

#### **Embed YouTube Video**

```html
<iframe
  width="560"
  height="315"
  src="https://www.youtube.com/embed/dQw4w9WgXcQ"
  title="YouTube video"
  frameborder="0"
>
</iframe>
```

#### **Embed Google Maps**

```html
<iframe width="600" height="400" src="https://www.google.com/maps/embed?pb=...">
</iframe>
```

---

## 💻 Practice Examples

### **Image Gallery**

```html
<section class="gallery">
  <img src="photo1.jpg" alt="Sunset" />
  <img src="photo2.jpg" alt="Mountain" />
  <img src="photo3.jpg" alt="Ocean" />
</section>
```

### **Media Player**

```html
<audio controls>
  <source src="song.mp3" type="audio/mpeg" />
</audio>

<video controls width="400">
  <source src="movie.mp4" type="video/mp4" />
</video>
```

---

## 📋 Checklist

- [ ] Use proper alt text
- [ ] Optimize image sizes
- [ ] Embed audio and video
- [ ] Use responsive images
- [ ] Understand iframe security

---

## 🔗 Next: [Day 4 - Forms](../Day_4/README.md)

_Remember: Always provide alt text for images for accessibility!_
