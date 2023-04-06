# meta-astrophi

The meta-astrophi layer defines configurations for building an astrophotography remote
control device.

## Dependencies

This layer depends on:

* URI: <git://git.yoctoproject.org/poky>
  * branch: kirkstone
* URI: <git://git.openembedded.org/meta-openembedded>
  * branch: kirkstone
* URI: <git://git.yoctoproject.org/meta-raspberrypi>
  * branch: kirkstone
  * Observation: should theoretically work on other devices, but it was only tested on the Raspberry Pi
  
## Building

1. source poky/oe-init-build-env rpi-build (`rpi-build` directory should exist)
2. Add the dependency layers and this one to `bblayers.conf` 
3. Set MACHINE in local.conf to `raspberrypi0-wifi` (or another supported board)
4. Set INIT_MANAGER in local.conf to `"systemv"`
5. Optional: Set ENABLE_UART in local.conf to "1" if you need to acces device over UART
6. `bitbake astrophi-zerow`
7. Copy the image using `bmaptool`: `sudo bmaptool copy --bmap astrophi-zerow-raspberrypi0-wifi.wic.bmap  astrophi-zerow-raspberrypi0-wifi.wic.bz2 [device_file]`
   
OR

7. Extract the `astrophi-zerow-raspberrypi0-wifi.wic.bz2` and copy it to an SD card (using `dd` or `cp`)
8. Boot your RPi

## Accessing the device

After booting, you should see a `AstroPhi` Wi-fi network, connect to it using `password` as password. 

The device contains an `astro` user with password `private`, you can connect to it using SSH.
