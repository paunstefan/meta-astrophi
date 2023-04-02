SUMMARY = "Astrophi custom Linux image"

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

inherit core-image
inherit extrausers

IMAGE_INSTALL += "openssh"
IMAGE_INSTALL += "python3"
IMAGE_INSTALL += "gphoto2"
IMAGE_INSTALL += "astro-scripts"

EXTRA_USERS_PARAMS = "\
                    useradd -p '$(openssl passwd private)' astro; \
                    groupadd astro; \
                    usermod  -a -G astro astro; \
                    usermod  -a -G sudo astro"