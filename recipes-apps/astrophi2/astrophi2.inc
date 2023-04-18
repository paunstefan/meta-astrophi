do_install:append () {
    install -d ${D}/var/www
    install -m 0666 ${WORKDIR}/static/index.html ${D}/var/www
}

DEPENDS = "gphoto2"
RDEPENDS:${PN} = "gphoto2"