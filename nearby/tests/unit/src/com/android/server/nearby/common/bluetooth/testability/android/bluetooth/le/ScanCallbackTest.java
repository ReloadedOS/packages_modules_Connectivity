/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.server.nearby.common.bluetooth.testability.android.bluetooth.le;

import android.platform.test.annotations.Presubmit;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.google.common.collect.ImmutableList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for {@link ScanCallback}.
 */
@Presubmit
@SmallTest
@RunWith(AndroidJUnit4.class)
public class ScanCallbackTest {
    @Mock android.bluetooth.le.ScanResult mScanResult;

    TestScanCallback mTestScanCallback = new TestScanCallback();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOnScanFailed_notCrash() {
        mTestScanCallback.unwrap().onScanFailed(1);
    }

    @Test
    public void testOnScanResult_notCrash() {
        mTestScanCallback.unwrap().onScanResult(1, mScanResult);
    }

    @Test
    public void testOnBatchScanResult_notCrash() {
        mTestScanCallback.unwrap().onBatchScanResults(ImmutableList.of(mScanResult));
    }

    private static class TestScanCallback extends ScanCallback { }
}
