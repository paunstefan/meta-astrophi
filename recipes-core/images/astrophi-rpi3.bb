SUMMARY = "Astrophi custom Linux image for the Raspberry Pi 3"

LICENSE = "MIT"

include astrophi-base.bb

IMAGE_INSTALL += "\
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455"

# 4GB extra space, make sure you have it on the card
IMAGE_ROOTFS_EXTRA_SPACE = "4194304"