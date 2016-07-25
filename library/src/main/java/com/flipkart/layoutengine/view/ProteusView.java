package com.flipkart.layoutengine.view;

import android.support.annotation.Nullable;
import android.view.View;

import com.flipkart.layoutengine.toolbox.Styles;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * A wrapper class to update the views build by a {@link com.flipkart.layoutengine.builder.LayoutBuilder}.
 * Enables consumers of the views built by the builder to update the data at
 * runtime.
 * <p>
 * The {@link com.flipkart.layoutengine.builder.LayoutBuilder#build} method returns a
 * {@link com.flipkart.layoutengine.view.ProteusView}. To use raw view call it's
 * {@link ProteusView#getView()} method.
 * </p>
 * In order to update the data associated with the {@link android.view.View} use the
 * {@link com.flipkart.layoutengine.view.ProteusView#updateData(com.google.gson.JsonObject)}.
 *
 * @author Aditya Sharat {@literal <aditya.sharat@flipkart.com>}
 */
public interface ProteusView {

    /**
     * @return the view {@link android.view.View} wrapped by the {@link ProteusView}
     */
    View getView();

    /**
     * @return the index of this view in it's parent.
     */
    int getIndex();

    /**
     * Sets the index of the proteus view in the parent
     *
     * @param index the index to be set
     */
    void setIndex(int index);

    /**
     * @return the parent {@link ProteusView} of this {@link ProteusView}.
     */
    ProteusView getParent();

    /**
     * Adds a child {@link ProteusView}.
     *
     * @param child The {@link ProteusView} to add as a child.
     */
    void addView(ProteusView child);

    /**
     * @return the list of children.
     */
    List<ProteusView> getChildren();

    /**
     * Updates the data associated with view wrapped by the {@link ProteusView}
     * with new {@link JsonObject} object.
     *
     * @param data new {@link JsonObject} object which will used to update the view.
     * @return reference to the updated view {@link android.view.View} wrapped by the
     * {@link ProteusView}
     */
    View updateData(JsonObject data);

    /**
     * Replaces the {@link ProteusView} in the hierarchy.
     *
     * @param view The {@link ProteusView} to use for the replacement
     */
    void replaceView(ProteusView view);

    /**
     * Deprecated, use {@link ProteusView#destroy()} instead
     */
    @Deprecated
    void removeView();

    /**
     * Removes the child view at the specified location from this {@code ProteusView}.
     *
     * @param childIndex the index of the object to remove.
     * @return the removed object.
     */
    @Nullable
    ProteusView removeView(int childIndex);

    /**
     * Returns the layout used to build this {@link ProteusView}
     *
     * @return Returns the layout used to build this {@link ProteusView}
     */
    @Nullable
    JsonObject getLayout();

    /**
     * Returns the current {@link Styles} used in this {@link ProteusView}
     *
     * @return Returns the current {@link Styles} used in this {@link ProteusView}
     */
    Styles getStyles();

    /**
     * Returns the {@link Styles} used in this {@link ProteusView}
     *
     * @param styles Returns the {@link Styles} used in this {@link ProteusView}
     */
    void setStyles(Styles styles);

    /**
     * Removes this {@link ProteusView} from the hierarchy and releases resources;
     */
    void destroy();
}