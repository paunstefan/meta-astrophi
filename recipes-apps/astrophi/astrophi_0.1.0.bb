SUMMARY = "Astrophotography camera control software"
HOMEPAGE = "https://github.com/paunstefan/astrophi"
LICENSE = "MIT"

inherit cargo

export BINDGEN_EXTRA_CLANG_ARGS
BINDGEN_EXTRA_CLANG_ARGS = "--sysroot=${WORKDIR}/recipe-sysroot -I${WORKDIR}/recipe-sysroot/usr/include"

SRC_URI += "git://git@github.com/paunstefan/astrophi.git;protocol=ssh;nobranch=1;branch=main"
SRCREV = "9f16e4c02b0c75143ed6ecbccd88966b9a841cf5"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=a55eb95beff031c355cacdab76c7edd2 \
"

do_compile:prepend () {
    # For reasons I don't currently understand, these headers are not present in the /usr/include directory
    cp ${WORKDIR}/recipe-sysroot-native/usr/lib/arm-poky-linux-gnueabi/gcc/arm-poky-linux-gnueabi/11.3.0/include/stdarg.h ${WORKDIR}/recipe-sysroot/usr/include/stdarg.h
    cp ${WORKDIR}/recipe-sysroot-native/usr/lib/arm-poky-linux-gnueabi/gcc/arm-poky-linux-gnueabi/11.3.0/include/stddef.h ${WORKDIR}/recipe-sysroot/usr/include/stddef.h
}

do_install:append () {
    install -d ${D}/var/www
    install -m 0666 ${WORKDIR}/git/static/index.html ${D}/var/www
}

do_compile[network] = "1"

DEPENDS = "libgphoto2"
RDEPENDS:${PN} = "libgphoto2"