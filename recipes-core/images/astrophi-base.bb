SUMMARY = "Astrophi custom Linux image base"

LICENSE = "MIT"

inherit core-image
inherit extrausers

hostname_pn-base-files = "astrophi"

DISTRO_FEATURES:append = " wifi "
IMAGE_INSTALL += "sudo net-tools openssh python3"
IMAGE_INSTALL += "gphoto2"
IMAGE_INSTALL += "astrophi-proto"
IMAGE_INSTALL += "gphoto2-udev"
IMAGE_INSTALL += "astrophi astrophi-service"

EXTRA_USERS_PARAMS = "\
                    useradd -p '$(openssl passwd private)' astro; \
                    groupadd astro; \
                    usermod  -a -G astro astro;"