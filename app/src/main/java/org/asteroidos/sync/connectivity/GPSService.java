/*
 * AsteroidOSSync
 * Copyright (c) 2023 AsteroidOS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.asteroidos.sync.connectivity;

import android.content.Context;
import android.preference.PreferenceManager;
import android.widget.CheckBox;

import org.asteroidos.sync.R;
import org.asteroidos.sync.asteroid.IAsteroidDevice;
import org.asteroidos.sync.services.GPSTracker;
import org.asteroidos.sync.utils.AsteroidUUIDS;
import org.osmdroid.config.Configuration;

import java.util.HashMap;
import java.util.UUID;

public class GPSService implements IConnectivityService {
    private final IAsteroidDevice mDevice;
    private final Context mCtx;
    private GPSTracker mGPS;
    public GPSService(Context ctx, IAsteroidDevice device) {
        mDevice = device;
        mCtx = ctx;

        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
    }
    private void sendMock() {
        final byte[] mockData = new byte[10];
        mDevice.send(AsteroidUUIDS.WEATHER_MAX_TEMPS_CHAR, mockData, GPSService.this);
    }
    @Override
    public void sync() {
    }

    @Override
    public void unsync() {

    }

    @Override
    public HashMap<UUID, Direction> getCharacteristicUUIDs() {
        return null;
    }

    @Override
    public UUID getServiceUUID() {
        return null;
    }
}