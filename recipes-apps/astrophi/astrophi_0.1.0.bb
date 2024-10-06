SUMMARY = "Astrophotography camera control software"
HOMEPAGE = "https://github.com/paunstefan/astrophi"
LICENSE = "MIT"

inherit cargo_bin

export BINDGEN_EXTRA_CLANG_ARGS
BINDGEN_EXTRA_CLANG_ARGS = "--sysroot=${WORKDIR}/recipe-sysroot -I${WORKDIR}/recipe-sysroot/usr/include"


SRC_URI += "git://git@github.com/paunstefan/astrophi.git;protocol=ssh;nobranch=1;branch=main"
SRCREV = "d73f8b58a5fae14288bc3e34596bbf8a49ffec87"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=a55eb95beff031c355cacdab76c7edd2 \
"

do_compile:prepend () {
    # For reasons I don't currently understand, these headers are not present in the /usr/include directory
    cp ${WORKDIR}/recipe-sysroot-native/usr/lib/arm-poky-linux-gnueabi/gcc/arm-poky-linux-gnueabi/11.4.0/include/stdarg.h ${WORKDIR}/recipe-sysroot/usr/include/stdarg.h
    cp ${WORKDIR}/recipe-sysroot-native/usr/lib/arm-poky-linux-gnueabi/gcc/arm-poky-linux-gnueabi/11.4.0/include/stddef.h ${WORKDIR}/recipe-sysroot/usr/include/stddef.h
}

do_install:append () {
    install -d ${D}/var/www
    install -m 0666 ${WORKDIR}/git/static/index.html ${D}/var/www
}

do_compile[network] = "1"

DEPENDS = "libgphoto2"
RDEPENDS:${PN} = "libgphoto2"