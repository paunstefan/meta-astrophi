SUMMARY = "Astrophi custom Linux image base"

LICENSE = "MIT"

inherit core-image
inherit extrausers

hostname_pn-base-files = "astrophi"

DISTRO_FEATURES:append = " wifi "
IMAGE_INSTALL += "sudo net-tools openssh python3 file"
IMAGE_INSTALL += "gphoto2 gphoto2-udev"
IMAGE_INSTALL += "astrophi-proto"
IMAGE_INSTALL += "astrophi astrophi-service"
IMAGE_INSTALL += "astrometry"

EXTRA_USERS_PARAMS = "\
                    useradd -p '$(openssl passwd private)' astro; \
                    groupadd astro; \
                    usermod  -a -G astro astro;"

PATH:append = ":/usr/local/astrometry/bin"
