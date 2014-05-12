package com.example.envapp;

import com.example.envapp.CameraFragment;

/**
 * Listener interface that has to be implemented by activities using
 * {@link CameraFragment} instances.
 *
 * @author Sebastian Kaspari <sebastian@androidzeitgeist.com>
 */
public interface CameraFragmentListener {
    /**
     * A non-recoverable camera error has happened.
     */
    public void onCameraError();
}
