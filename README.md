webandnative
============

Demonstration of a Web / Android project using native API's

I read a description of [Google's Inbox project][inbox] that described their
strategy of sharing a Java library of their core logic between an Android
project, an iOS project, and a GWT web project. I was frustrated with the
cross-platform library I was using, so I thought I would try to write a
demonstration of how to share your core logic between native projects on each
platform. So far, I'm just targeting GWT and Android.

Here are some useful references:

* [GWT ClientBundle reference][clientbundle] 
* how to create a [GWT ClientBundle in Eclipse][clientbundle-eclipse]
* creating [linked resources in Eclipse][linking]
* reading [resource files][resources] in an Android project

[clientbundle]: http://www.gwtproject.org/doc/latest/DevGuideClientBundle.html
[clientbundle-eclipse]: https://developers.google.com/eclipse/docs/gwt_clientbundle
[linking]: http://help.eclipse.org/juno/index.jsp?topic=%2Forg.eclipse.platform.doc.user%2Ftasks%2Ftasks-45.htm
[resources]: http://developer.android.com/reference/android/content/res/Resources.html

Here's a summary of the options I've found for building an application without
a lot of graphics and deploying on Android and HTML, with the possibility of
deploying to iOS:

* Native Java looks best for now, as shown in this demonstration. I may also
  experiment with [GWT exporter][exporter]. If I decide to target iOS, I could
  try [using j2objc][j2objc].
    * Good: native UI usually looks much better (if I have the skills).
    * Good: Google's Inbox project used this approach, so they might know what
      they're doing.
    * Bad: have to write the UI twice.
    * Bad: I'm not that fond of Java, and even less fond of Javascript.
    * Bad: debugging is slower when you have to deploy to Android or compile to
      Javascript first.
* [Kivy][kivy] is a set of Python libraries that target the desktop, Android,
  and iOS. I just started playing with the tutorials, and it looks like it
  would be nice to work with, but the lack of an HTML platform is putting me
  off for now.
    * Good: I love Python.
    * Good: documentation looks good, so far.
    * Good: labels and text fields are easy.
    * Bad: no support for HTML yet. Might be able to merge with
      [CodeSkulptor][skulpt], [Pyjs][pyjs], or [Brython][brython]. I created issue
      kivy/kivy#2715 requesting HTML support, but it was declined.
* [libgdx][libgdx] is the first platform I tried. It's written in Java and
  compiled with GWT into Javascript for the HTML platform.
    * Good: the graphics support is good, and animating with sprites works well.
    * Good: documentation is pretty good, and lots of discussion on StackOverflow.com.
    * Bad: the graphics require WebGL, so some browsers don't support it.
    * Bad: I'm not that fond of Java.
    * Bad: the GUI widgets, in particular, were not easy to work with. Trying
      to let the user drag buttons around and rearrange things was a pain.
    * Bad: text support was weak. You had to convert your font to a bitmap and
      then changing the font size looked terrible.
    * Bad: upgrading to a new release didn't work, and I gave up on it.
* [PlayN][playn] looked like an interesting alternative to libgdx. It's also a
  Java platform that supports a bunch of different targets.
    * Good: it still works in HTML, even without WebGL.
    * Good: text display is much easier.
    * Good: libraries are in maven repository, so setting up the project is
      easier than libgdx.
    * Bad: no support for text fields on Android or HTML.
    * Bad: documentation not as good as libgdx, hardly any discussion on
      StackOverflow.com. However, one of the developers is pretty good about
      answering questions.

[libgdx]: http://libgdx.badlogicgames.com/
[playn]: https://github.com/threerings/playn/
[kivy]: http://kivy.org
[skulpt]: http://www.codeskulptor.org/
[brython]: http://www.brython.info/
[pyjs]: http://pyjs.org/
[inbox]: http://gmailblog.blogspot.ca/2014/11/going-under-hood-of-inbox.html
[j2objc]: https://github.com/google/j2objc
[exporter]: https://code.google.com/p/gwt-exporter/
