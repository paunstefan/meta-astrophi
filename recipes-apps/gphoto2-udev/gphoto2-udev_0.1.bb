DESCRIPTION = "Udev rules for libgphoto2"
LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://20-gphoto.hwdb \
        file://20-libgphoto2.rules"


do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0666 ${WORKDIR}/20-libgphoto2.rules ${D}${sysconfdir}/udev/rules.d
    install -d ${D}${sysconfdir}/udev/hwdb.d
    install -m 0666 ${WORKDIR}/20-gphoto.hwdb ${D}${sysconfdir}/udev/hwdb.d
}