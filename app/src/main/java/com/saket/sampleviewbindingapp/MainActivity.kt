package com.saket.sampleviewbindingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.saket.sampleviewbindingapp.databinding.ActivityMainBinding

/**
Using ViewBinding. In many cases it replaces findViewById.
To use ViewBinding, first enable it in the build.gradle file under android {} -
    viewBinding {
        enabled = true
    }

The gradle sync and rebuild the code. This should generate a binding class for each layout xml in the app.
The name of the binding class is the layout file name in camel case followed by the word "Binding"
So for activity_main.xml -> ActivityMainBinding is generated.

Using the binding class you can access the root view and the individual views that have id assigned to them.




View binding has important advantages over using findViewById:

Null safety: Since view binding creates direct references to views, there's no risk of a null pointer exception due to an invalid view ID.
Additionally, when a view is only present in some configurations of a layout, the field containing its reference in the binding class is marked with @Nullable.
Type safety: The fields in each binding class have types matching the views they reference in the XML file. This means that there's no risk of a class cast exception.
These differences mean that incompatibilities between your layout and your code will result in your build failing at compile time rather than at runtime.

Conversely, view binding has the following limitations compared to data binding:

View binding doesn't support layout variables or layout expressions, so it can't be used to declare dynamic UI content straight from XML layout files.
View binding doesn't support two-way data binding.
Because of these considerations, it is best in some cases to use both view binding and data binding in a project.
You can use data binding in layouts that require advanced features and use view binding in layouts that do not.

 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Get root view from binding class
        val rootView = binding.root
        setContentView(rootView)
        //Get individual view by their Ids
        binding.nameText.text = "Hello Activity Viewbinding!"
    }
}
