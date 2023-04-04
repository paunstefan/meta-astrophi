SUMMARY = "Astrophi custom Linux image for the Raspberry Pi Zero W"

LICENSE = "MIT"

include astrophi-base.bb

IMAGE_INSTALL += "linux-firmware-rpidistro-bcm43430 bluez-firmware-rpidistro-bcm43430a1-hcd"